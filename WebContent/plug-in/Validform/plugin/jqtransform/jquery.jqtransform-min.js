(function(d){var c={preloadImg:true};var e=false;var i=function(l){l=l.replace(/^url\((.*)\)/,"$1").replace(/^\"(.*)\"$/,"$1");var j=new Image();j.src=l.replace(/\.([a-zA-Z]*)$/,"-hover.$1");var k=new Image();k.src=l.replace(/\.([a-zA-Z]*)$/,"-focus.$1")};var b=function(l){var j=d(l.get(0).form);var m=l.next();if(!m.is("label")){m=l.prev();if(m.is("label")){var k=l.attr("id");if(k){m=j.find('label[for="'+k+'"]')}}}if(m.is("label")){return m.css("cursor","pointer")}return false};var a=function(j){var k=d(".jqTransformSelectWrapper ul:visible");k.each(function(){var l=d(this).parents(".jqTransformSelectWrapper:first").find("select").get(0);if(!(j&&l.oLabel&&l.oLabel.get(0)==j.get(0))){d(this).hide()}})};var f=function(j){if(d(j.target).parents(".jqTransformSelectWrapper").length===0){a(d(j.target))}};var h=function(){d(document).mousedown(f)};var g=function(k){var j;d(".jqTransformSelectWrapper select",k).each(function(){j=(this.selectedIndex<0)?0:this.selectedIndex;d("ul",d(this).parent()).each(function(){d("a:eq("+j+")",this).click()})});d("a.jqTransformCheckbox, a.jqTransformRadio",k).removeClass("jqTransformChecked");d("input:checkbox, input:radio",k).each(function(){if(this.checked){d("a",d(this).parent()).addClass("jqTransformChecked")}})};d.fn.jqTransInputButton=function(){return this.each(function(){var j=d('<button id="'+this.id+'" name="'+this.name+'" type="'+this.type+'" class="'+this.className+' jqTransformButton"><span><span>'+d(this).attr("value")+"</span></span>").hover(function(){j.addClass("jqTransformButton_hover")},function(){j.removeClass("jqTransformButton_hover")}).mousedown(function(){j.addClass("jqTransformButton_click")}).mouseup(function(){j.removeClass("jqTransformButton_click")});d(this).replaceWith(j)})};d.fn.jqTransInputText=function(){return this.each(function(){var m=d(this);if(m.hasClass("jqtranformdone")||!m.is("input")){return}m.addClass("jqtranformdone");var l=b(d(this));l&&l.bind("click",function(){m.focus()});var j=m.width();if(m.attr("size")){j=m.attr("size")*10;m.css("width",j)}m.addClass("jqTransformInput").wrap('<div class="jqTransformInputWrapper"><div class="jqTransformInputInner"><div></div></div></div>');var k=m.parent().parent().parent();k.css("width",j+10);m.focus(function(){k.addClass("jqTransformInputWrapper_focus")}).blur(function(){k.removeClass("jqTransformInputWrapper_focus")}).hover(function(){k.addClass("jqTransformInputWrapper_hover")},function(){k.removeClass("jqTransformInputWrapper_hover")});d.browser.safari&&k.addClass("jqTransformSafari");d.browser.safari&&m.css("width",k.width()+16);this.wrapper=k})};d.fn.jqTransCheckBox=function(){return this.each(function(){if(d(this).hasClass("jqTransformHidden")){return}var m=d(this);var k=this;var l=b(m);l&&l.click(function(){j.trigger("click")});var j=d('<a href="#" class="jqTransformCheckbox"></a>');m.addClass("jqTransformHidden").wrap('<span class="jqTransformCheckboxWrapper"></span>').parent().prepend(j);m.change(function(){this.checked&&j.addClass("jqTransformChecked")||j.removeClass("jqTransformChecked");return true});j.click(function(){if(m.attr("disabled")){return false}m.trigger("click").trigger("change");return false});this.checked&&j.addClass("jqTransformChecked")})};d.fn.jqTransRadio=function(){return this.each(function(){if(d(this).hasClass("jqTransformHidden")){return}var l=d(this);var k=this;oLabel=b(l);oLabel&&oLabel.click(function(){j.trigger("click")});var j=d('<a href="#" class="jqTransformRadio" rel="'+this.name+'"></a>');l.addClass("jqTransformHidden").wrap('<span class="jqTransformRadioWrapper"></span>').parent().prepend(j);l.change(function(){k.checked&&j.addClass("jqTransformChecked")||j.removeClass("jqTransformChecked");return true});j.click(function(){if(l.attr("disabled")){return false}l.trigger("click").trigger("change");d('input[name="'+l.attr("name")+'"]',k.form).not(l).each(function(){d(this).attr("type")=="radio"&&d(this).trigger("change")});return false});k.checked&&j.addClass("jqTransformChecked")})};d.fn.jqTransTextarea=function(){return this.each(function(){var j=d(this);if(j.hasClass("jqtransformdone")){return}j.addClass("jqtransformdone");oLabel=b(j);oLabel&&oLabel.click(function(){j.focus()});var l='<table cellspacing="0" cellpadding="0" border="0" class="jqTransformTextarea">';l+='<tr><td id="jqTransformTextarea-tl"></td><td id="jqTransformTextarea-tm"></td><td id="jqTransformTextarea-tr"></td></tr>';l+='<tr><td id="jqTransformTextarea-ml">&nbsp;</td><td id="jqTransformTextarea-mm"><div></div></td><td id="jqTransformTextarea-mr">&nbsp;</td></tr>';l+='<tr><td id="jqTransformTextarea-bl"></td><td id="jqTransformTextarea-bm"></td><td id="jqTransformTextarea-br"></td></tr>';l+="</table>";var k=d(l).insertAfter(j).hover(function(){!k.hasClass("jqTransformTextarea-focus")&&k.addClass("jqTransformTextarea-hover")},function(){k.removeClass("jqTransformTextarea-hover")});j.focus(function(){k.removeClass("jqTransformTextarea-hover").addClass("jqTransformTextarea-focus")}).blur(function(){k.removeClass("jqTransformTextarea-focus")}).appendTo(d("#jqTransformTextarea-mm div",k));this.oTable=k;if(d.browser.safari){d("#jqTransformTextarea-mm",k).addClass("jqTransformSafariTextarea").find("div").css("height",j.height()).css("width",j.width())}})};d.fn.jqTransSelect=function(){return this.each(function(o){var j=d(this);if(j.hasClass("jqTransformHidden")){return}if(j.attr("multiple")){return}var p=b(j);var n=j.addClass("jqTransformHidden").wrap('<div class="jqTransformSelectWrapper"></div>').parent().css({zIndex:10-o});n.prepend('<div><span></span><a href="#" class="jqTransformSelectOpen"></a></div><ul></ul>');var l=d("ul",n).css("width",j.width()).hide();d("option",this).each(function(t){var u=d('<li><a href="#" index="'+t+'">'+d(this).html()+"</a></li>");l.append(u)});l.find("a").click(function(){d("a.selected",n).removeClass("selected");d(this).addClass("selected");if(j[0].selectedIndex!=d(this).attr("index")&&j[0].onchange){j[0].selectedIndex=d(this).attr("index");j[0].onchange()}j[0].selectedIndex=d(this).attr("index");d("span:eq(0)",n).html(d(this).html());l.hide();return false});d("a:eq("+this.selectedIndex+")",l).click();d("span:first",n).click(function(){d("a.jqTransformSelectOpen",n).trigger("click")});p&&p.click(function(){d("a.jqTransformSelectOpen",n).trigger("click")});this.oLabel=p;var r=d("a.jqTransformSelectOpen",n).click(function(){if(l.css("display")=="none"){a()}if(j.attr("disabled")){return false}l.slideToggle("fast",function(){var t=(d("a.selected",l).offset().top-l.offset().top);l.animate({scrollTop:t})});return false});var q=j.outerWidth();var m=d("span:first",n);var k=(q>m.innerWidth())?q+r.outerWidth():n.width();n.css("width",k);l.css("width",k-2);m.css({width:q});l.css({display:"block",visibility:"hidden"});var s=(d("li",l).length)*(d("li:first",l).height());(s<l.height())&&l.css({height:s,overflow:"hidden"});l.css({display:"none",visibility:"visible"})})};d.fn.jqTransform=function(j){var k=d.extend({},c,j);return this.each(function(){var l=d(this);if(l.hasClass("jqtransformdone")){return}l.addClass("jqtransformdone");d('input:submit, input:reset, input[type="button"]',this).jqTransInputButton();d("input:text, input:password",this).jqTransInputText();d("input:checkbox",this).jqTransCheckBox();d("input:radio",this).jqTransRadio();d("textarea",this).jqTransTextarea();if(d("select",this).jqTransSelect().length>0){h()}l.bind("reset",function(){var m=function(){g(this)};window.setTimeout(m,10)})})}})(jQuery);
