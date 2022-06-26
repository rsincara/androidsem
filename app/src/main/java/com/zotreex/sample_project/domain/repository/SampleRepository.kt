package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.data.SampleItem

interface SampleRepository {
    suspend fun getSampleList(): List<SampleItem>

    suspend fun getSampleItem(id: Int): SampleItem
}