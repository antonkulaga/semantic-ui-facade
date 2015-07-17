package org.denigma.preview

import org.denigma.binding.views.BindableView
import org.querki.jquery._
import org.scalajs.dom.raw.HTMLElement
import org.semantic.{DropDownConfig, AccordionConfig}
import org.semantic.ui._

class DropDownView(val elem:HTMLElement,val params:Map[String,Any] = Map.empty[String,Any]) extends BindableView {

  override def bindElement(el: HTMLElement) = {
    super.bindElement(el)
    $(el).dropdown(DropDownConfig.allowAdditions(true))
  }
  override def activateMacro(): Unit = { extractors.foreach(_.extractEverything(this))}

  override protected def attachBinders(): Unit =  binders =  BindableView.defaultBinders(this)
}
