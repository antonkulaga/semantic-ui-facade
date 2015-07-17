package org.denigma.preview

import org.denigma.binding.views.BindableView
import org.scalajs.dom.raw.HTMLElement
import rx.core.Var
import org.querki.jquery._

class ExampleView(val elem:HTMLElement,val params:Map[String,Any] = Map.empty[String,Any]) extends BindableView {

  override def bindElement(el: HTMLElement) = {
    super.bindElement(el)
  }
  override def activateMacro(): Unit = { extractors.foreach(_.extractEverything(this))}

  override protected def attachBinders(): Unit =  binders =  BindableView.defaultBinders(this)
}
