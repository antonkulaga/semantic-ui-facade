package org.semantic

import org.querki.jquery
import org.querki.jquery.JQuery
import org.querki.jsext._
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport


package object ui {

  implicit class SemanticUIJquery(jq:JQuery) extends Jex(jq){
    def tab(config:TabConfig):JQuery = dyno(j=>j.tab(config))
    def tab(): JQuery = dyno(j=>j.tab())
    def sidebar(config:SidebarConfig): Sidebar = new Sidebar(dyno(_.sidebar(config)))
    def accordion(config:AccordionConfig):JQuery = dyno(_.accordion(config))
    def accordion():JQuery = dyno(_.accordion())
    def dropdown() = dyno(_.dropdown())
    def dropdown(config:DropDownConfig) = dyno(_.dropdown(config))
  }

  class Sidebar(jq:JQuery) extends Jex(jq){
    def show() = {dyno(_.sidebar("show")); this }
    def hide() = {dyno(_.sidebar("hide")); this }
    def toggle() = {dyno(_.sidebar("toggle")); this }
    def isVisible = {dyno(_.sidebar("is vissible")); this }
    def isHidden = {dyno(_.sidebar("is hidden")); this }
    def pushPage() = {dyno(_.sidebar("push page")); this }
    def pullPage() = {dyno(_.sidebar("pull page")); this }
    def addBodyCss() = {dyno(_.sidebar("add body css")); this }
    def removeBodyCss() = {dyno(_.sidebar("remove body css")); this }
  }

  class Jex(jq:JQuery) extends jquery.JQueryExtensions(jq){
    def dyno(fun:js.Dynamic=>Any) = fun(jq.asInstanceOf[js.Dynamic]).asInstanceOf[JQuery]
  }

}


trait SidebarConfig extends js.Object
object SidebarConfig extends SidebarConfigBuilder(noOpts)
class SidebarConfigBuilder(val dict:OptMap) extends JSOptionBuilder[SidebarConfig,SidebarConfigBuilder](new SidebarConfigBuilder(_)){
  def context(value:HTMLElement) = jsOpt("context",value) //context	body	Context which sidebar will appear inside
  def exclusive(value:Boolean) = jsOpt("exclusive",value) //exclusive	false	Whether multiple sidebars can be open at once
  def closable(value:Boolean) = jsOpt("closable",value) //closable	true	Whether sidebar can be closed by clicking on page
  def dimPage(value:Boolean) = jsOpt("dimPage",value) //dimPage	true	Whether to dim page contents when sidebar is visible
  def scrollLock(value:Boolean) = jsOpt("scrollLock",value) //scrollLock	false	Whether to lock page scroll when sidebar is visible
  def returnScroll(value:Boolean) = jsOpt("returnScroll",value) //returnScroll	false	Whether to return to original scroll position when sidebar is hidden, automatically occurs with transition: scale
  def delaySetup(value:Boolean) = jsOpt("delaySetup",value) //delaySetup	false	When sidebar is initialized without the proper html, using this option will defer creation of DOM to use requestAnimationFrame.
  def useLegacy(value:Boolean) = jsOpt("useLegacy",value)

}

class TabConfig extends js.Object
object TabConfig extends TabConfigBuilder(noOpts)
class TabConfigBuilder(val dict:OptMap) extends JSOptionBuilder[TabConfig, TabConfigBuilder](new TabConfigBuilder(_)) {
  def auto(value:Boolean) = jsOpt("auto",value) //auto	false	Whether tab should load remote content as same url as history
  def history(value:Boolean) = jsOpt("history",value) //history	false	Whether to record history events for tab changes
  def ignoreFirstLoad(value:Boolean) = jsOpt("ignoreFirstLoad",value) //ignoreFirstLoad	false	Do not load content remotely on first tab load. Useful when open tab is rendered on server.
  def evaluateScripts(value:Boolean): TabConfigBuilder = jsOpt("evaluateScripts",value) //evaluateScripts	once	Whether inline scripts in tab html should be parsed on tab load. Defaults to once, parsing only on first load. Can also be set to true or false to always parse or never parse inline scripts.
  def evaluateScripts(value:String): TabConfigBuilder = jsOpt("evaluateScripts",value) //evaluateScripts	once	Whether inline scripts in tab html should be parsed on tab load. Defaults to once, parsing only on first load. Can also be set to true or false to always parse or never parse inline scripts.
  def alwaysRefresh(value:Boolean) = jsOpt("alwaysRefresh",value) //exclusive	false	Whether multiple sidebars can be open at once
  def cache(value:Boolean) = jsOpt("cache",value) //cache	true	Tab should cache content after loading locally to avoid server trip on second load
  def apiSettings(value:Boolean) = jsOpt("apiSettings",value) //  apiSettings	false	Settings object for $.api call
  def historyType(value:String) = jsOpt("historyType",value) //    historyType	hash	Can be set to hash or state. Hash will use an in-page link to create history events. State will use DOM History and load pages from server on refresh.
  def context(value:HTMLElement) = jsOpt("context",value) //Tabs are limited to those found inside this context
  def path(value:String) = jsOpt("path",value) //path	false	When using historyType state you must specify the base URL for all internal links.
  def childrenOnly(value:Boolean) = jsOpt("childrenOnly",value) //childrenOnly	false	If enabled limits tabs to children of passed context
  def mayDepth(value:Integer) = jsOpt("mayDepth",value) //  mayDepth	25	Maximum amount of nested tabs allowed (avoids recursion)*/

  def onFirstLoad(fun:js.Function3[String,js.Array[Any],Any,Unit]) = jsOpt("onFirstLoad",fun)
  def onLoad(fun:js.Function3[String,js.Array[Any],Any,Unit]) = jsOpt("onLoad",fun)
  def onVisible(fun:js.Function3[String,js.Array[Any],Any,Unit]) = jsOpt("onVisible",fun)
  def onRequest(fun:js.Function3[String,js.Array[Any],Any,Unit]) = jsOpt("onRequest",fun)

  def selector(value:TabSelector) = jsOpt("selector",value)
}
@JSExport
case class TabSelector(tabs:String = ".ui.tab",ui:String = ".ui")



trait AccordionConfig extends js.Object
object AccordionConfig extends AccordionConfigBuilder(noOpts)
class AccordionConfigBuilder(val dict:OptMap) extends JSOptionBuilder[AccordionConfig,AccordionConfigBuilder](new AccordionConfigBuilder(_)){
  def exclusive(value:Boolean) = jsOpt("exclusive",value) //exclusive	true	Only allow one section open at a time
  def animateChildren(value:Boolean) = jsOpt("animateChildren",value) //Whether child content opacity should be animated (may cause performance issues with many child elements)
  def collapsible(value:Boolean) = jsOpt("collapsible",value) //Whether child content opacity should be animated (may cause performance issues with many child elements)
  def closeNested(value:Boolean) = jsOpt("closeNested",value) //Close open nested accordion content when an element closes
  def on(value:String) = jsOpt("on",value) //Event on title that will cause accordion to open
  def duration(value:Int) = jsOpt("duration",value)
  def easing(value:String) = jsOpt("easing",value)

  def onOpening(fun:js.Function0[Unit]) = jsOpt("onOpening",fun)
  def onOpen(fun:js.Function0[Unit]) = jsOpt("onOpen",fun)
  def onClosing(fun:js.Function0[Unit]) = jsOpt("onClosing",fun)
  def onClose(fun:js.Function0[Unit]) = jsOpt("onClose",fun)
  def onChange(fun:js.Function0[Unit]) = jsOpt("onChange",fun)

  def debug(value:String) = jsOpt("debug",value)
  def verbose(value:String) = jsOpt("verbose",value)
  def performance(value:String) = jsOpt("performance",value)

  def selector(value: AccordionSelector) = jsOpt("selector",value)

}

@JSExport
case class AccordionSelector(accordion:String,title:String,trigger:String,content:String)


class SearchConfig extends js.Object
object SearchConfig extends SearchConfigBuilder(noOpts)

class SearchConfigBuilder(val dict:OptMap) extends JSOptionBuilder[SearchConfig, SearchConfigBuilder](new SearchConfigBuilder(_)) {

  //def apiSettings(value:js.Dictionary) = jsOpt("apiSettings",value)
  def minCharacters(value:Int) = jsOpt("minCharacters",value)
  //TODO: complete
}

trait DropDownConfig extends js.Object
object DropDownConfig extends DropDownConfigBuilder(noOpts) //http://semantic-ui.com/modules/dropdown.html#/settings
class DropDownConfigBuilder(val dict:OptMap) extends JSOptionBuilder[DropDownConfig,DropDownConfigBuilder](new DropDownConfigBuilder(_)){
  def on(value:String) = jsOpt("on",value)
  def allowAdditions(value:Boolean) = jsOpt("allowAdditions",value)
  def action(value:String) = jsOpt("action",value)
  def `match`(value:String) = jsOpt("match",value)
  def forceSelection(value:Boolean) = jsOpt("forceSelection",value)
  def allowCategorySelection(value:Boolean) = jsOpt("allowCategorySelection",value)
  def placeholder(value:String) = jsOpt("placeholder",value)
  def apiSettings(value:Boolean): DropDownConfigBuilder = jsOpt("apiSettings",value)
  def saveRemoteData(value:Boolean) = jsOpt("saveRemoteData",value)
  def useLabels(value:Boolean) = jsOpt("useLabels",value)
  def maxSelection(value:Boolean) = jsOpt("maxSelections",value)
  def glyphWidth(value:Int) = jsOpt("glyphWidth",value)
  def label(value:DropDownLabel) = jsOpt("label",value)
  def direction(value:String) = jsOpt("direction",value)
  def keepOnScreen(value:Boolean) = jsOpt("keepOnScreen",value)
  def context(value:HTMLElement) = jsOpt("context",value)
  def fullTextSearch(value:String) = jsOpt("fullTextSearch",value)
  def preserveHTML(value:Boolean) = jsOpt("preserveHTML",value)
  def sortSelect(value:Boolean) = jsOpt("sortSelect",value)
  def showOnFocus(value:Boolean) = jsOpt("showOnFocus",value)
  def allowTab(value:Boolean) = jsOpt("allowTab",value)
  def transition(value:String) = jsOpt("transition",value)
  def duration(value:Int) = jsOpt("duration",value)
  def delay(value:DropDownDelay) = jsOpt("dropDownDelay",value)

  def onChange(fun:js.Function3[String,String,JQuery,Unit]) = jsOpt("onChange",fun)
  def onAdd(fun:js.Function3[String,String,JQuery,Unit]) = jsOpt("onAdd",fun)
  def onRemove(fun:js.Function3[String,String,JQuery,Unit]) = jsOpt("onRemove",fun)
  def onLabelCreate(fun:js.Function1[JQuery,JQuery]) = jsOpt("onLabelCreate",fun)
  def onLabelSelect(fun:js.Function1[JQuery,Unit]) = jsOpt("onLabelSelect",fun)
  def onNoREsult(fun:js.Function1[String,Unit]) = jsOpt("onNoResult",fun)
  def onShow(fun:js.Function0[Unit]) = jsOpt("onShow",fun)
  def onHide(fun:js.Function0[Unit]) = jsOpt("onHide",fun)


}

@JSExport
case class DropDownLabel(transition:String,duration:Int,variation:Boolean)

@JSExport
case class DropDownDelay(hide:Int,show:Int,search:Int,touch:Int)