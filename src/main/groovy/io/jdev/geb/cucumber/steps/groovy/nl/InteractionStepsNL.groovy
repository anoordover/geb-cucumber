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
import io.jdev.geb.cucumber.core.InteractionSteps
import io.jdev.geb.cucumber.core.nl.FieldFinderNL
import io.jdev.geb.cucumber.core.nl.WebDutchDecoder

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before
import static cucumber.api.groovy.NL.Als
import static cucumber.api.groovy.NL.Dan
import static cucumber.api.groovy.NL.Gegeven

InteractionSteps steps = new InteractionSteps()

Before { Scenario scenario ->
    steps.before(scenario, binding, new FieldFinderNL(), new WebDutchDecoder())
}

After { Scenario scenario ->
    steps.after(scenario)
}

Gegeven(~/^ik (.*) in het (.*) veld (?:type|selecteer)$/) { String value, String fieldDesc ->
    steps.enter(value, fieldDesc)
}

Als(~/^ik type de volgende waarde(?:n|s):$/) { DataTable dataTable ->
    steps.enterValues(null, dataTable)
}

Als(~/^ik type de volgende waarde(?:n|s) uit (de (?:.*)):$/) { String varName, DataTable dataTable ->
    steps.enterFromVariable(null, varName, dataTable)
}

Als(~/^ik type de volgende waarde(?:n|s) in de (.*) sectie:$/) { String fieldDesc, DataTable dataTable ->
    steps.enterValues(fieldDesc, dataTable)
}

Als(~/^ik type de volgende waarde(?:n|s) in de (.*) sectie uit (de (?:.*)):/) { String fieldDesc, String varName, DataTable dataTable ->
    steps.enterFromVariable(fieldDesc, varName, dataTable)
}

Dan(~/^(?:matcht |heeft )(uiteindelijk )?(?:het|de) (.*?)(?: veld| label)? (?:de )?waarde (?:van )?(.*)$/) { String eventually, String fieldDesc, String value ->
    steps.hasValue(eventually as boolean, value, fieldDesc)
}

Dan(~/^is (uiteindelijk )?(?:het|de) (.*?)(?: veld| label)? aanwezig$/) { String eventually, String fieldDesc ->
    steps.isPresent(eventually as boolean, fieldDesc)
}

Dan(~/^is (uiteindelijk )?het (.*?)(?: veld| label)? afwezig$/) { String eventually, String fieldDesc ->
    steps.isNotPresent(eventually as boolean, fieldDesc)
}

Dan(~/^is (uiteindelijk )?het (.*?)(?: veld| label)? zichtbaar$/) { String eventually, String fieldDesc ->
    steps.isVisible(eventually as boolean, fieldDesc)
}

Dan(~/^is (uiteindelijk )?(?:het|de) (.*?)(?: veld| label)? onzichtbaar$/) { String eventually, String fieldDesc ->
    steps.isNotVisible(eventually as boolean, fieldDesc)
}

Als(~/^ik klik (?:op )?de (.*?)(?: checkbox| box)?$/) { String fieldDesc ->
    steps.click(fieldDesc)
}

Dan(~/^is (uiteindelijk )?de (.*) (?:check)?box aangevinkt$/) { String eventually, String fieldDesc ->
    steps.isChecked(eventually as boolean, fieldDesc)
}

Dan(~/^is (uiteindelijk )?de (.*) (?:check)?box niet aangevinkt$/) { String eventually, String fieldDesc ->
    steps.isNotChecked(eventually as boolean, fieldDesc)
}

Dan(~/^heeft (uiteindelijk )?de pagina de volgende waarde(?:n|s):$/) { String eventually, DataTable dataTable ->
    steps.hasValues(eventually as boolean, null, dataTable)
}

Dan(~/^heeft (uiteindelijk )?de pagina de volgende waarde(?:n|s) uit (de (?:.*)):$/) { String eventually, String varName, DataTable dataTable ->
    steps.hasValuesFromVariable(eventually as boolean, null, varName, dataTable)
}

Dan(~/^heeft (uiteindelijk )?de (.*) sectie de volgende waarde(?:n|s):$/) { String eventually, String fieldDesc, DataTable dataTable ->
    steps.hasValues(eventually as boolean, fieldDesc, dataTable)
}

Dan(~/^heeft (uiteindelijk )?de (.*) sectie de volgende waarde(?:n|s) uit (de (?:.*)):$/) { String eventually, String fieldDesc, String varName, DataTable dataTable ->
    steps.hasValuesFromVariable(eventually as boolean, fieldDesc, varName, dataTable)
}

Dan(~/^heeft (uiteindelijk )?de (.*) tabel (\d+) rijen?$/) { String eventually, String fieldDesc, int rows ->
    steps.hasRows(eventually as boolean, fieldDesc, rows)
}

Dan(~/^heeft (uiteindelijk )?de (.*) tabel geen rijen?$/) { String eventually, String fieldDesc ->
    steps.hasRows(eventually as boolean, fieldDesc, 0)
}

Dan(~/^heeft (uiteindelijk )?de (.*) tabel de volgende waarde(?:n|s):$/) { String eventually, String fieldDesc, DataTable dataTable ->
    steps.hasRowValues(eventually as boolean, fieldDesc, dataTable)
}

Dan(~/^heeft (uiteindelijk )?de (.*) tabel (?:een )?rijen? matchend met de volgende waarde(?:n|s):$/) { String eventually, String fieldDesc, DataTable dataTable ->
    steps.hasRowsMatching(eventually as boolean, fieldDesc, dataTable, "$fieldDesc matching row")
}

Dan(~/^heeft (uiteindelijk )?de (.*) tabel geen rijen mnatchend met de volgende waarde(?:n|s):$/) { String eventually, String fieldDesc, DataTable dataTable ->
    steps.hasNoRowsMatching(eventually as boolean, fieldDesc, dataTable)
}
