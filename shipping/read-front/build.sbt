enablePlugins(JavaAppPackaging)
mainClass in Compile := Some("akka.kernel.Main ecommerce.shipping.app.ShippingReadFrontApp")

dockerExposedPorts := Seq(9310)