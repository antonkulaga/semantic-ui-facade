package org.denigma.preview

import org.denigma.binding.views.BindableView
import org.querki.jquery._
import org.scalajs.dom.raw.HTMLElement
import org.semantic.AccordionConfig
import org.semantic.ui._

class AccordionView(val elem:HTMLElement,val params:Map[String,Any] = Map.empty[String,Any]) extends BindableView {

  override def bindElement(el: HTMLElement) = {
    super.bindElement(el)
    $(el).accordion(AccordionConfig.exclusive(false))
  }
  override def activateMacro(): Unit = { extractors.foreach(_.extractEverything(this))}

  override protected def attachBinders(): Unit =  binders =  BindableView.defaultBinders(this)
}
