/* ******************************************************************************
 * Copyright (c) 2006-2012 XMind Ltd. and others.
 * 
 * This file is a part of XMind 3. XMind releases 3 and
 * above are dual-licensed under the Eclipse Public License (EPL),
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 * and the GNU Lesser General Public License (LGPL), 
 * which is available at http://www.gnu.org/licenses/lgpl.html
 * See http://www.xmind.net/license.html for details.
 * 
 * Contributors:
 *     XMind Ltd. - initial API and implementation
 *******************************************************************************/
package org.xmind.ui.internal.decorations;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.xmind.gef.draw2d.graphics.Path;
import org.xmind.ui.decorations.AbstractBranchConnection;

public class NoneBranchConnection extends AbstractBranchConnection {

    public NoneBranchConnection() {
        super();
    }

    public NoneBranchConnection(String id) {
        super(id);
    }

    public void paint(IFigure figure, Graphics graphics) {
        // do nothing
    }

    public void paintShadow(IFigure figure, Graphics graphics) {
        // do nothing
    }

    public boolean containsPoint(IFigure figure, int x, int y) {
        return false;
    }

    protected void route(IFigure figure, Path shape) {
    }

}