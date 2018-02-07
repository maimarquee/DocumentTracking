package com.ezshop.action.staff;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.ezshop.dto.StaffDTO;

public class StaffLastNameComparator implements Comparator<Object>, Serializable {
	private static final long serialVersionUID = 1L;
	
	public int compare(Object o1, Object o2) {
		String str1 = ((StaffDTO)o1).getLastName();
        String str2 = ((StaffDTO)o2).getLastName();
        return str1.compareTo(str2);
	}
	public void sort(List<Object> list) {
		Collections.sort(list, new StaffLastNameComparator());
    }
}
