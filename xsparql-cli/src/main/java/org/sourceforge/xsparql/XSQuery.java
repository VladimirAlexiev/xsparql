/**
 *
 * Copyright (C) 2011, NUI Galway.
 * Copyright (C) 2014, NUI Galway, WU Wien, Politecnico di Milano, 
 * Vienna University of Technology
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   * The names of the COPYRIGHT HOLDERS AND CONTRIBUTORS may not be used
 *     to endorse or promote products derived from this software without
 *     specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ''AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 *
 * Created on 09 February 2011 by Reasoning and Querying Unit (URQ), 
 * Digital Enterprise Research Institute (DERI) on behalf of NUI Galway.
 * 20 May 2014 by Axel Polleres on behalf of WU Wien, Daniele Dell'Aglio 
 * on behalf of Politecnico di Milano, Stefan Bischof on behalf of Vienna 
 * University of Technology,  Nuno Lopes on behalf of NUI Galway.
 *
 */ 

package org.sourceforge.xsparql;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.saxon.Configuration;
import net.sf.saxon.Query;
import net.sf.saxon.trans.CommandLineOptions;

import org.sourceforge.xsparql.rewriter.XSPARQLProcessor;
import org.sourceforge.xsparql.xquery.saxon.createNamedGraphExtFunction;
import org.sourceforge.xsparql.xquery.saxon.createScopedDatasetExtFunction;
import org.sourceforge.xsparql.xquery.saxon.deleteNamedGraphExtFunction;
import org.sourceforge.xsparql.xquery.saxon.deleteScopedDatasetExtFunction;
import org.sourceforge.xsparql.xquery.saxon.getRDBTableAttributesExtFunction;
import org.sourceforge.xsparql.xquery.saxon.getRDBTablesExtFunction;
import org.sourceforge.xsparql.xquery.saxon.jsonDocExtFunction;
import org.sourceforge.xsparql.xquery.saxon.scopedDatasetPopResultsExtFunction;
import org.sourceforge.xsparql.xquery.saxon.sparqlQueryExtFunction;
import org.sourceforge.xsparql.xquery.saxon.sparqlQueryTDBExtFunction;
import org.sourceforge.xsparql.xquery.saxon.sparqlScopedDatasetExtFunction;
import org.sourceforge.xsparql.xquery.saxon.sqlQueryExtFunction;
import org.sourceforge.xsparql.xquery.saxon.turtleGraphToURIExtFunction;

/**
 * @author Nuno Lopes
 *
 */
public class XSQuery extends Query {

    /**
     * 
     */
    public XSQuery() {
	super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	new XSQuery().doQuery(args, "org.deri.xsparql.XSQuery");
    }
    
    private final static Logger logger = Logger.getLogger(XSPARQLProcessor.class
	      .getClass().getName());

    public void applyLocalOptions(CommandLineOptions options, Configuration config) {
	super.applyLocalOptions(options, config);

	logger.setLevel(Level.WARNING);

	try { 
	    config.registerExtensionFunction(new sparqlQueryExtFunction());
	    config.registerExtensionFunction(new turtleGraphToURIExtFunction());
	    config.registerExtensionFunction(new createScopedDatasetExtFunction());
	    config.registerExtensionFunction(new sparqlScopedDatasetExtFunction());
	    config.registerExtensionFunction(new deleteScopedDatasetExtFunction());
	    config.registerExtensionFunction(new scopedDatasetPopResultsExtFunction());
	    config.registerExtensionFunction(new jsonDocExtFunction());
	    config.registerExtensionFunction(new createNamedGraphExtFunction());
	    config.registerExtensionFunction(new deleteNamedGraphExtFunction());
	    config.registerExtensionFunction(new sparqlQueryTDBExtFunction());

	    // RDB functions
	    config.registerExtensionFunction(new sqlQueryExtFunction());
	    config.registerExtensionFunction(new getRDBTablesExtFunction());
	    config.registerExtensionFunction(new getRDBTableAttributesExtFunction());

        } catch (Exception ex) {
            throw new IllegalArgumentException();
	}
	    

    }

}
