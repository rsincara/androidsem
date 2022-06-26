package com.zotreex.sample_project.domain.usecases.getSampleList

import com.zotreex.sample_project.domain.data.SampleItem

interface GetSampleListUseCase {
    suspend operator fun invoke(): List<SampleItem>
}