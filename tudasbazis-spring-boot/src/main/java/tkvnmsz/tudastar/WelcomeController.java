/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tkvnmsz.tudastar;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class WelcomeController {
	@Autowired
	private SessionData sessionData;
	
	
	@GetMapping("/")
	public String welcome(Model model) {
		return Pages.MAIN_PAGE;
	}
	
	/*
	@RequestMapping("/test/{id}")
	public String test(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		return "test";
	}*/
}
