package org.elasticsearch.rest.action.sample

import org.elasticsearch.rest.BaseRestHandler
import org.elasticsearch.rest.RestController
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.client.Client
import org.elasticsearch.rest.RestRequest.Method
import org.elasticsearch.rest.RestChannel
import org.elasticsearch.rest.RestRequest
import org.elasticsearch.rest.BytesRestResponse
import java.nio.charset.StandardCharsets
import org.elasticsearch.common.xcontent.XContentType
import org.elasticsearch.common.inject.Inject

class RestHelloAction@Inject()(settings: Settings, client: Client, controller: RestController) extends BaseRestHandler(settings, client) {

  controller.registerHandler(Method.POST, "/{index}/_hello", this)

  def handleRequest(request: RestRequest, channel: RestChannel) = {
    var data: String = request.content().toUtf8()

    channel.sendResponse(new BytesRestResponse(data.getBytes(StandardCharsets.UTF_8), XContentType.JSON.restContentType()))
  }
}
