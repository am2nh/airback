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

import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.TextField;

/**
 * @author airback Ltd.
 * @since 5.0.3
 */
public class ShortcutExtension {
    public static TextField installShortcutAction(final TextField textField, final ShortcutListener listener) {
        textField.addFocusListener(focusEvent -> textField.addShortcutListener(listener));
        textField.addBlurListener(blurEvent -> textField.removeShortcutListener(listener));
        return textField;
    }
}
