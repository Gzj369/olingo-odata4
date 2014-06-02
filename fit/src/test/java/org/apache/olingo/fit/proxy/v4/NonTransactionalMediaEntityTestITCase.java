/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.fit.proxy.v4;

import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.ext.proxy.EntityContainerFactory;

import org.apache.olingo.client.api.v4.EdmEnabledODataClient;
import org.apache.olingo.fit.proxy.v4.demo.odatademo.DemoService;

public class NonTransactionalMediaEntityTestITCase extends MediaEntityTestITCase {

  private EntityContainerFactory<EdmEnabledODataClient> ecf;

  private DemoService ime;

  @Override
  protected EntityContainerFactory<EdmEnabledODataClient> getContainerFactory() {
    if (ecf == null) {
      ecf = EntityContainerFactory.getV4(testDemoServiceRootURL, false);
      ecf.getClient().getConfiguration().setDefaultBatchAcceptFormat(ContentType.APPLICATION_OCTET_STREAM);
    }
    return ecf;
  }

  @Override
  protected DemoService getContainer() {
    if (ime == null) {
      ime = getContainerFactory().getEntityContainer(DemoService.class);
    }
    return ime;
  }

}