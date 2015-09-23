/*
 * Copyright (C) 2003-2008 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.ecm.webui.component.explorer.control.filter;

import org.exoplatform.services.cms.documents.AutoVersionService;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;
import org.exoplatform.webui.ext.filter.UIExtensionAbstractFilter;
import org.exoplatform.webui.ext.filter.UIExtensionFilterType;

import javax.jcr.Node;
import java.util.Map;

/**
 * Filter for document auto versioning
 */
public class IsSupportVersioningFilter extends UIExtensionAbstractFilter {

  public IsSupportVersioningFilter() {
    this(null);
  }

  public IsSupportVersioningFilter(String messageKey) {
    super(messageKey, UIExtensionFilterType.MANDATORY);
  }

  public boolean accept(Map<String, Object> context) throws Exception {
    if (context == null)
      return true;
    Node currentNode = (Node) context.get(Node.class.getName());
    AutoVersionService autoVersionService = WCMCoreUtils.getService(AutoVersionService.class);
    return autoVersionService.isVersionSupport(currentNode.getPath(), currentNode.getSession().getWorkspace().getName());
  }

  public void onDeny(Map<String, Object> context) throws Exception {
  }

}
