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
package com.airback.vaadin.web.ui.field;

import com.airback.vaadin.web.ui.LabelLink;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.Label;
import org.apache.commons.lang3.StringUtils;

/**
 * @author airback Ltd.
 * @since 4.5.3
 */
public class LinkViewField extends CustomField<Object> {
    private static final long serialVersionUID = 1L;

    private String value;
    private Object iconResourceLink;
    private String href;

    public LinkViewField(String value, String href) {
        this(value, href, null);
    }

    public LinkViewField(String value, String href, Object iconResourceLink) {
        this.value = value;
        this.href = href;
        this.iconResourceLink = iconResourceLink;
    }

    @Override
    protected Component initContent() {
        if (StringUtils.isNotBlank(value)) {
            final LabelLink l = new LabelLink(value, href);
            if (iconResourceLink != null) {
                l.setIconLink(iconResourceLink);
            }
            l.setWidth("100%");
            return l;
        } else {
            final Label l = new Label("&nbsp;", ContentMode.HTML);
            l.setWidth("100%");
            return l;
        }
    }

    @Override
    protected void doSetValue(Object s) {

    }

    @Override
    public String getValue() {
        return null;
    }
}
