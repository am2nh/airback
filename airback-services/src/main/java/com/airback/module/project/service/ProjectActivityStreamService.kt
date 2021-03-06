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
 * along with this program.  If not, see <http:></http:>//www.gnu.org/licenses/>.
 */
package com.airback.module.project.service

import com.airback.common.domain.criteria.ActivityStreamSearchCriteria
import com.airback.db.arguments.BasicSearchRequest
import com.airback.core.cache.CacheKey
import com.airback.core.cache.Cacheable
import com.airback.db.persistence.service.IService
import com.airback.module.project.domain.ProjectActivityStream

/**
 * @author airback Ltd.
 * @since 4.0
 */
interface ProjectActivityStreamService : IService {
    @Cacheable
    fun getTotalActivityStream(@CacheKey criteria: ActivityStreamSearchCriteria): Int

    @Cacheable
    fun getProjectActivityStreams(@CacheKey searchRequest: BasicSearchRequest<ActivityStreamSearchCriteria>): List<ProjectActivityStream>
}
