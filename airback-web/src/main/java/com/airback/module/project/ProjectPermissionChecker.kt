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
package com.airback.module.project

import com.airback.module.project.service.ProjectMemberService
import com.airback.spring.AppContextUtil
import com.airback.vaadin.AppUI
import com.airback.vaadin.UserUIContext

/**
 * @author airback Ltd
 * @since 5.2.8
 */
object ProjectPermissionChecker {
    private val memberService: ProjectMemberService
        get() = AppContextUtil.getSpringBean(ProjectMemberService::class.java)

    @JvmStatic
    fun canWrite(prjId: Int, permissionItem: String): Boolean {
        val member = memberService.findMemberByUsername(UserUIContext.getUsername(), prjId, AppUI.accountId)
        return if (member != null) {
            val permissionMap = member.permissionMap
            permissionMap != null && permissionMap.canWrite(permissionItem)
        } else false
    }
}
