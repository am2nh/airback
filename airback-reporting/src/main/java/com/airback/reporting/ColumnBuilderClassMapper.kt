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
package com.airback.reporting

import com.airback.reporting.generator.ComponentBuilderGenerator
import java.util.concurrent.ConcurrentHashMap

/**
 * @author airback Ltd.
 * @since 4.1.2
 */
object ColumnBuilderClassMapper {
    private val mapInjection = mutableMapOf<Class<*>, Map<String, ComponentBuilderGenerator>>()

    @JvmStatic
    fun put(cls: Class<*>, columns: Map<String, ComponentBuilderGenerator>) {
        mapInjection.put(cls, columns)
    }

    @JvmStatic
    fun getListFieldBuilder(cls: Class<*>): Map<String, ComponentBuilderGenerator>? = mapInjection[cls]
}
