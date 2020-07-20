/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.searchablesnapshots.minio;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.xpack.searchablesnapshots.AbstractSearchableSnapshotsRestTestCase;

import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;

public class MinioSearchableSnapshotsIT extends AbstractSearchableSnapshotsRestTestCase {

    @Override
    protected String repositoryType() {
        return "s3";
    }

    @Override
    protected Settings repositorySettings() {
        final String bucket = System.getProperty("test.minio.bucket");
        assertThat(bucket, not(blankOrNullString()));

        final String basePath = System.getProperty("test.minio.base_path");
        assertThat(basePath, not(blankOrNullString()));

        return Settings.builder().put("client", "searchable_snapshots").put("bucket", bucket).put("base_path", basePath).build();
    }
}
