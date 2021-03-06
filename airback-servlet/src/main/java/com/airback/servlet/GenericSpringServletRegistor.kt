/**
 * Copyright © airback
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:></http:>//www.gnu.org/licenses/>.
 */
package com.airback.servlet

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author airback Ltd
 * @since 5.5.0
 */
@Configuration
class GenericSpringServletRegistor {

    @Bean("errorServlet")
    fun errorServlet() = ServletRegistrationBean(AppExceptionServletHandler(), "/error")

    @Bean("tooltipServlet")
    fun tooltipServlet() = ServletRegistrationBean(TooltipGeneratorServletRequestHandler(), "/tooltip/*")
}
