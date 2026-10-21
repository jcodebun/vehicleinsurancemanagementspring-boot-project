package com.vehicleinsurancemgt.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vehicleinsurancemgt.dto.BuyPolicyDTO;
import com.vehicleinsurancemgt.dto.NotificationDTO;
import com.vehicleinsurancemgt.dto.UserDTO;
import com.vehicleinsurancemgt.service.BuyPolicyServiceInt;
import com.vehicleinsurancemgt.service.PolicyServiceInt;
import com.vehicleinsurancemgt.util.DataUtility;

@Controller
public class WelcomeCtl {

	@Autowired
	private BuyPolicyServiceInt buyService;

	@Autowired
	private PolicyServiceInt policyService;

	@GetMapping({"/welcome","/"})
	public String display(Model model) {
		return "welcome";
	}

	@GetMapping("/aboutUs")
	public String aboutUs(Model model) {
		return "aboutUs";
	}

	@GetMapping("/contactUs")
	public String contactUs(Model model) {
		return "contactUs";
	}

	@GetMapping("/notification")
	public String notification(HttpSession session, Model model) {
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		
		if(uDto==null) {
			return "redirect:/login";
		}
		
		BuyPolicyDTO buyDto = new BuyPolicyDTO();
		buyDto.setUserId(uDto.getId());
		List<BuyPolicyDTO> list = buyService.search(buyDto);
		List<NotificationDTO> nfList = new ArrayList<NotificationDTO>();
		if (list.size() != 0) {
			for (BuyPolicyDTO buyPolicyDTO : list) {
				System.out.println(DataUtility.getDateDiffrence(buyPolicyDTO.getRenewalDate()));
				long days = DataUtility.getDateDiffrence(buyPolicyDTO.getRenewalDate());
				days = DataUtility.getLong(String.valueOf(days));
				System.out.println("Days----" + days);
				if (days <= 2 && days >= 0) {
					nfList.add(new NotificationDTO(buyPolicyDTO.getPolicyName(), buyPolicyDTO.getRenewalDate(),
							buyPolicyDTO.getPoilicyId(), buyPolicyDTO.getId()));
				}
			}
			if (nfList.size() == 0) {
				model.addAttribute("error", "No Notification Available");
			} else {
				model.addAttribute("list", nfList);
			}

		} else {
			model.addAttribute("error", "No Notification Available");
		}
		return "notification";
	}

}
