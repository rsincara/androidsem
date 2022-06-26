package com.zotreex.sample_project.domain.usecases.getSampleList

import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.repository.SampleRepository
import javax.inject.Inject

class GetSampleListUseCaseImpl @Inject constructor(
    private val sampleRepository: SampleRepository
) : GetSampleListUseCase {
    override suspend fun invoke(): List<SampleItem> = sampleRepository.getSampleList()
}