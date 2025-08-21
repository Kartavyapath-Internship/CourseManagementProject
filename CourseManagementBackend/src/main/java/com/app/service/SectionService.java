package com.app.service;

import java.util.List;


import com.app.dto.SectionReqDto;
import com.app.entity.Section;

public interface SectionService {

	List<Section> getAllSection(int subId);

	Section addNewSection(SectionReqDto srd);

	Section updateSection(int subId, SectionReqDto srd);

}
