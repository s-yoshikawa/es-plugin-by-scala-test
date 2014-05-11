package org.elasticsearch.plugin

import java.util.Collection

import org.elasticsearch.plugins.AbstractPlugin
import org.elasticsearch.rest.RestModule
import org.elasticsearch.search.hazelcast.RestHelloAction

object Esplugin extends AbstractPlugin {

  override def name(): String = "estest"
  override def description(): String = "this is test"
  
  def onModule(module: RestModule): Unit = {
    module.addRestAction(classOf[RestHelloAction]);
  }

}