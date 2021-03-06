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
package com.airback.module.project.view.settings

import com.airback.common.UrlTokenizer
import com.airback.core.ResourceNotFoundException
import com.airback.db.arguments.NumberSearchField
import com.airback.module.project.domain.ProjectRole
import com.airback.module.project.domain.criteria.ProjectRoleSearchCriteria
import com.airback.module.project.event.ProjectEvent
import com.airback.module.project.service.ProjectRoleService
import com.airback.module.project.view.ProjectUrlResolver
import com.airback.module.project.view.parameters.ProjectRoleScreenData
import com.airback.module.project.view.parameters.ProjectScreenData
import com.airback.spring.AppContextUtil
import com.airback.vaadin.AppUI
import com.airback.vaadin.EventBusFactory
import com.airback.vaadin.mvp.PageActionChain

/**
 * @author airback Ltd
 * @since 6.0.0
 */
class RoleUrlResolver : ProjectUrlResolver() {
    init {
        this.addSubResolver("list", ListUrlResolver())
        this.addSubResolver("preview", PreviewUrlResolver())
        this.addSubResolver("edit", EditUrlResolver())
        this.addSubResolver("add", AddUrlResolver())
    }

    private class ListUrlResolver : ProjectUrlResolver() {
        override fun handlePage(vararg params: String) {
            val projectId = UrlTokenizer(params[0]).getInt()
            val roleSearchCriteria = ProjectRoleSearchCriteria()
            roleSearchCriteria.projectId = NumberSearchField(projectId)
            val chain = PageActionChain(ProjectScreenData.Goto(projectId), ProjectRoleScreenData.Search(roleSearchCriteria))
            EventBusFactory.getInstance().post(ProjectEvent.GotoMyProject(this, chain))
        }
    }

    private class PreviewUrlResolver : ProjectUrlResolver() {
        override fun handlePage(vararg params: String) {
            val token = UrlTokenizer(params[0])
            val projectId = token.getInt()
            val roleId = token.getInt()
            val chain = PageActionChain(ProjectScreenData.Goto(projectId), ProjectRoleScreenData.Read(roleId))
            EventBusFactory.getInstance().post(ProjectEvent.GotoMyProject(this, chain))
        }
    }

    private class EditUrlResolver : ProjectUrlResolver() {
        override fun handlePage(vararg params: String) {
            val token = UrlTokenizer(params[0])
            val projectId = token.getInt()
            val roleId = token.getInt()
            val roleService = AppContextUtil.getSpringBean(ProjectRoleService::class.java)
            val role = roleService.findById(roleId, AppUI.accountId)
            if (role != null) {
                val chain = PageActionChain(ProjectScreenData.Goto(projectId), ProjectRoleScreenData.Add(role))
                EventBusFactory.getInstance().post(ProjectEvent.GotoMyProject(this, chain))
            } else {
                throw ResourceNotFoundException("Can not find resource $params")
            }
        }
    }

    private class AddUrlResolver : ProjectUrlResolver() {
        override fun handlePage(vararg params: String) {
            val token = UrlTokenizer(params[0])
            val projectId = token.getInt()
            val chain = PageActionChain(ProjectScreenData.Goto(projectId), ProjectRoleScreenData.Add(ProjectRole()))
            EventBusFactory.getInstance().post(ProjectEvent.GotoMyProject(this, chain))
        }
    }
}