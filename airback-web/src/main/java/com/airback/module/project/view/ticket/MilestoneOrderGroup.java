/**
 * Copyright © airback
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.airback.module.project.view.ticket;

import com.airback.core.utils.SortedArrayMap;
import com.airback.module.project.domain.ProjectTicket;
import com.airback.module.project.ui.components.TicketRowRender;

import java.util.List;

/**
 * @author airback Ltd
 * @since 5.4.6
 */
public class MilestoneOrderGroup extends TicketGroupOrderComponent {
    private SortedArrayMap<Integer, MilestoneTicketGroupComponent> milestonesAvailable = new SortedArrayMap<>();
    private MilestoneTicketGroupComponent unspecifiedTickets;

    public MilestoneOrderGroup() {
        super();
    }

    public MilestoneOrderGroup(Class<? extends TicketRowRender> ticketRowRenderCls) {
        super(ticketRowRenderCls);
    }

    @Override
    public void insertTickets(List<ProjectTicket> tickets) {
        for (ProjectTicket ticket : tickets) {
            Integer milestoneId = ticket.getMilestoneId();
            if (milestoneId != null) {
                if (milestonesAvailable.containsKey(milestoneId)) {
                    MilestoneTicketGroupComponent groupComponent = milestonesAvailable.get(milestoneId);
                    groupComponent.insertTicketComp(buildRenderer(ticket));
                } else {
                    MilestoneTicketGroupComponent groupComponent = new MilestoneTicketGroupComponent(milestoneId);
                    milestonesAvailable.put(milestoneId, groupComponent);
                    int index = milestonesAvailable.getKeyIndex(milestoneId);
                    if (index > -1) {
                        addComponent(groupComponent, index);
                    } else {
                        if (unspecifiedTickets != null) {
                            addComponent(groupComponent, getComponentCount() - 1);
                        } else {
                            addComponent(groupComponent);
                        }
                    }

                    groupComponent.insertTicketComp(buildRenderer(ticket));
                }
            } else {
                if (unspecifiedTickets == null) {
                    unspecifiedTickets = new MilestoneTicketGroupComponent(null);
                    addComponent(unspecifiedTickets);
                }
                unspecifiedTickets.insertTicketComp(buildRenderer(ticket));
            }
        }
    }
}
