/**
 * Copyright © airback
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.airback.schedule.jobs

import com.airback.common.domain.LiveInstance
import com.airback.common.service.AppPropertiesService
import com.airback.configuration.ServerConfiguration
import com.airback.core.Version
import com.airback.module.project.dao.ProjectMapper
import com.airback.module.project.domain.ProjectExample
import com.airback.module.user.dao.UserMapper
import com.airback.module.user.domain.UserExample
import org.quartz.JobExecutionContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

/**
 * @author airback Ltd
 * @since 6.0.0
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
class LiveInstanceMonitorJob : GenericQuartzJobBean() {

    @Autowired
    private lateinit var projectMapper: ProjectMapper

    @Autowired
    private lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var appPropertiesService: AppPropertiesService

    @Autowired
    private lateinit var serverConfiguration: ServerConfiguration

    override fun executeJob(context: JobExecutionContext) {
        val numProjects = projectMapper.countByExample(ProjectExample()).toInt()
        val numUsers = userMapper.countByExample(UserExample()).toInt()

        val liveInstance = LiveInstance()
        liveInstance.appversion = Version.getVersion()
        liveInstance.installeddate = LocalDate.now()
        liveInstance.javaversion = System.getProperty("java.version")
        liveInstance.sysid = appPropertiesService.sysId
        liveInstance.sysproperties = "${System.getProperty("os.arch")}:${System.getProperty("os.name")}:${System.getProperty("os.name")}"
        liveInstance.numprojects = numProjects
        liveInstance.numusers = numUsers
        liveInstance.edition = appPropertiesService.edition
        val restTemplate = RestTemplate()
        restTemplate.postForObject(serverConfiguration.getApiUrl("checkInstance"), liveInstance, String::class.java)
    }
}