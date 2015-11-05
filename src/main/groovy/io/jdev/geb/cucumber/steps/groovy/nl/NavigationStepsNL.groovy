/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 the original author or authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.jdev.geb.cucumber.steps.groovy.nl
import cucumber.api.DataTable
import cucumber.api.Scenario
import io.jdev.geb.cucumber.core.NavigationSteps
import io.jdev.geb.cucumber.core.nl.PageFinderNL
import io.jdev.geb.cucumber.core.nl.WebDutchDecoder

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before
import static cucumber.api.groovy.NL.Als
import static cucumber.api.groovy.NL.Dan

NavigationSteps steps = new NavigationSteps()

Before { Scenario scenario ->
    steps.before(scenario, binding, PageFinderNL.instance, new WebDutchDecoder())
}

After { Scenario scenario ->
    steps.after(scenario)
}

Als(~/^ik naar de (.* (?:pagina|dialoog)) ga$/) { String pageName ->
    steps.to(pageName)
}

Als(~/^ik naar de (.* (?:pagina|dialoog)) met parameters:$/) { String pageName, DataTable dataTable ->
    steps.to(pageName, dataTable)
}

Als(~/^ik naar de (.* (?:pagina|dialoog)) ga voor (de .*)$/) { String pageName, String paramName ->
    steps.to(pageName, paramName - 'de ', paramName)
}

Als(~/^ik naar de (.* (?:pagina|dialoog)) ga voor (.*) van (.*)$/) { String pageName, String paramName, String paramValue ->
    steps.to(pageName, paramName, paramValue)
}

Als(~/^ik via de (.* (?:pagina|dialoog)) ga$/) { String pageName ->
    steps.via(pageName)
}

Als(~/^ik via de (.* (?:pagina|dialoog)) met parameters ga:$/) { String pageName, DataTable dataTable ->
    steps.via(pageName, dataTable)
}

Als(~/^ik via de (.* (?:pagina|dialoog)) ga voor (.*) van (.*)$/) { String pageName, String paramName, String paramValue ->
    steps.via(pageName, paramName, paramValue)
}

Als(~/^ik via de (.* (?:pagina|dialoog)) ga voor (de .*)$/) { String pageName, String paramName ->
    steps.to(pageName, paramName - 'de ', paramName)
}

Dan(~/^ben ik (uiteindelijk )?op de (.* (?:pagina|dialoog))$/) { String eventually, String pageName ->
    steps.at(eventually as boolean, pageName)
}

Als(~/^ik (\d+) sekonden wacht$/) { int seconds ->
    steps.pause(seconds)
}

Als(~/^ik ga naar '(.*)'$/) { String path ->
    steps.go(path)
}

Als(~/^ik ga naar '(.*)' met parameters:$/) { String path, DataTable table ->
    steps.go(path, table)
}

Dan(~/^ben ik (uiteindelijk )?op '(.*)'$/) { String eventually, String path ->
    steps.atPath(eventually as boolean, path)
}

Dan(~/^verschijnt (uiteindelijk )?een popup window$/) { String eventually ->
    // ignore eventually here as popping windows up always needs a bit of a waitFor
    steps.assertPopup()
}

Als(~/^ik overschakel naar het popup window$/) { ->
    steps.switchToPopup(null)
}

Dan(~/^verschijnt (uiteindelijk )?de (.* (?:pagina|dialoog)) popup$/) { String eventually, String pageName ->
    // ignore eventually here as popping windows up always needs a bit of a waitFor
    steps.switchToPopup(pageName)
}

Als(~/^ik het popup window sluit$/) { ->
    steps.closePopup()
}

Dan(~/^sluit (uiteindelijk )?het popup window$/) { String eventually ->
    // ignore eventually here as closing windows always needs a bit of a waitFor
    steps.popupClosed()
}

Dan(~/^verschijnt (uiteindelijk )?een alert box$/) { String eventually ->
    // ignore eventually here as alerts frequently need a bit of a waitFor
    // and we do it automatically
    steps.hasAlert(null)
}

Dan(~/^verschijnt (uiteindelijk )?een alert box met de melding (.*)$/) { String eventually, String message ->
    // ignore eventually here as alerts frequently need a bit of a waitFor
    // and we do it automatically
    steps.hasAlert(message)
}

Als(~/^ik de alert box accepteer$/) { ->
    steps.acceptAlert()
}

Als(~/^ik de alert box annuleer$/) { ->
    steps.dismissAlert()
}

Als(~/^ik in de alter box (.*) type$/) { String text ->
    steps.enterAlertPrompt(text)
}
