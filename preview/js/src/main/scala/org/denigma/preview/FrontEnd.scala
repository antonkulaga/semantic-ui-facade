package org.denigma.preview

import org.denigma.binding.extensions.sq
import org.denigma.binding.views.BindableView
import org.denigma.binding.views.utils.ViewInjector
import org.querki.jquery._
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLElement
import org.denigma.binding.extensions._
import org.semantic.SidebarConfig

import scala.collection.immutable.Map
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scala.util.Try

/**
 * Just a simple view for the whole app, if interested ( see https://github.com/antonkulaga/scala-js-binding )
 */
@JSExport("FrontEnd")
object FrontEnd extends BindableView with scalajs.js.JSApp
{

  override def name = "main"

  override val params: Map[String, Any] = Map.empty

  lazy val elem: HTMLElement = dom.document.body

  val sidebarParams = SidebarConfig.exclusive(false).dimPage(false).closable(false)
  /**
   * Register views
   */
  ViewInjector
    .register("sidebar", (el, params) => Try(new SidebarView(el,params)))
    .register("ExampleView",(el,params) => Try(new ExampleView(el,params)))
    .register("TabView",(el,params) => Try(new TabView(el,params)))
    .register("Accordion",(el,params) => Try(new AccordionView(el,params)))
    .register("DropDown",(el,params) => Try(new DropDownView(el,params)))


  @JSExport
  def main(): Unit = {
    this.bindView(this.viewElement)

  }

  @JSExport
  def showLeftSidebar() = {
    import org.semantic.ui._
    $(".left.sidebar").sidebar(sidebarParams).show()
  }

  @JSExport
  def load(content: String, into: String): Unit = {
    dom.document.getElementById(into).innerHTML = content
  }

  @JSExport
  def moveInto(from: String, into: String): Unit = {
    for {
      ins <- sq.byId(from)
      intoElement <- sq.byId(into)
    } {
      this.loadElementInto(intoElement, ins.innerHTML)
      ins.parentNode.removeChild(ins)
    }
  }

  override def activateMacro(): Unit = {
    extractors.foreach(_.extractEverything(this))
  }

  def attachBinders() = {
    this.binders = BindableView.defaultBinders(this)
  }
}
