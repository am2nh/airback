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
package com.airback.core

/**
 * This exception when user do some invalid action such as typing wrong
 * password, invalid input. Note that airback catch this type exception to
 * recognize user mistake
 *
 * @author airback Ltd.
 * @since 1.0
 */
open class UserInvalidInputException : airbackException {

    constructor(message: String) : super(message)

    constructor(e: Throwable) : super(e)

    constructor(message: String, e: Throwable) : super(message, e)
}