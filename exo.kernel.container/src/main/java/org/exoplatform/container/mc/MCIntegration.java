/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.container.mc;

import org.picocontainer.ComponentAdapter;

import javax.servlet.ServletContext;

/**
 * The interface used to loosely couple mc-integration to exo-container
 *
 * @author <a href="mailto:mstrukel@redhat.com">Marko Strukelj</a>
 */
public interface MCIntegration
{
   /**
    * Apply mc-integration interception.
    *
    * @param componentAdapter the original component adapter
    * @return appropriate compomnent adapter - either the original,
    * or one wrapping the original with mc-integration wrapper
    */
   ComponentAdapter getMCAdapter(ComponentAdapter componentAdapter);

   /**
    * Check if JBoss MC Kernel is available.
    *
    * @param adapter
    * @return true if mc kernel is available
    */
   boolean hasMCKernel(ComponentAdapter adapter);

   /**
    * Initialize thread context with mc kernel retrieved through ServletContext.
    *
    * @param ctx Servlet context
    */
   void initThreadCtx(ServletContext ctx);

   /**
    * Clean up any thread context data stored during initThreadCtx().
    * 
    * @param ctx Servlet context
    */
   void resetThreadCtx(ServletContext ctx);
}