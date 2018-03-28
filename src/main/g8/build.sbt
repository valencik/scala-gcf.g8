import scala.sys.process._

organization := "$package$"
name := "$name;format="lower,hyphen"$"
scalaVersion := "2.12.5"

enablePlugins(ScalaJSPlugin)
scalaJSModuleKind := ModuleKind.CommonJSModule

InputKey[Unit]("gcfDeploy") := {
  val projectId = "$projectId$"
  val region = "$region$"

  val gcTarget = target.value / "gcloud"
  val function = gcTarget / "function.js"
  val functionName = "$name;format="camel"$"
  sbt.IO.copyFile((fastOptJS in Compile).value.data, function)
  s"gcloud beta functions deploy \$functionName --source \${gcTarget.getAbsolutePath} --stage-bucket \${name.value} --trigger-http --project \$projectId --region \$region"!
}
