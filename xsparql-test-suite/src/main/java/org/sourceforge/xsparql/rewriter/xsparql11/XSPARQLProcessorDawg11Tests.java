/**
 *
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
 * Created on 20 May 2014 by Axel Polleres on behalf of WU Wien, Daniele Dell'Aglio 
 * on behalf of Politecnico di Milano, Stefan Bischof on behalf of Vienna 
 * University of Technology,  Nuno Lopes on behalf of NUI Galway.
 *
 */ 

package org.sourceforge.xsparql.rewriter.xsparql11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.sourceforge.xsparql.rewriter.XSPARQLProcessor;
import org.sourceforge.xsparql.rewriter.XSPARQLProcessorTests;
import org.sourceforge.xsparql.test.Utils;

@RunWith(value = Parameterized.class)
public class XSPARQLProcessorDawg11Tests extends XSPARQLProcessorTests {
	public XSPARQLProcessorDawg11Tests(String filename){
		processor = new XSPARQLProcessor();
		this.filename=filename;
	}
	
	@Parameters(name = "{index} -> {0}")
	public static Collection<Object[]> data() {
		List<Object[]> data = new ArrayList<Object[]>();
		for (String filename : Utils.listFiles(XSPARQLProcessorDawg11Tests.class.getClassLoader().getResource("xsparql/testcases-dawg-sparql-1.1").getFile(), ".xsparql", true)) {
			data.add(new Object[]{filename});
		}
		return data;
	}

	@Test public void shouldParseQuery() { super.shouldParseQuery(); }
	@Test public void shouldRewriteQuery() {super.shouldRewriteQuery(); }
	@Test public void shouldSimplifyQuery() { super.shouldSimplifyQuery(); }
	@Test public void shouldSerialiseQuery() { super.shouldSimplifyQuery(); }

}
