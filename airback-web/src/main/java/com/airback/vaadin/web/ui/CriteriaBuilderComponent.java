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
package com.airback.vaadin.web.ui;

import com.airback.db.arguments.SearchCriteria;
import com.airback.db.query.SearchFieldInfo;

import java.util.List;

/**
 * @author airback Ltd
 * @since 5.4.4
 */
public interface CriteriaBuilderComponent<S extends SearchCriteria> {
    List<SearchFieldInfo<S>> buildSearchFieldInfos();
}
