/*
 * Copyright 2014 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.net.intent.constraint;

import org.junit.Test;
import org.onosproject.net.Link;
import org.onosproject.net.resource.Bandwidth;
import org.onosproject.net.resource.Lambda;

import com.google.common.testing.EqualsTester;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Unit tests for Constraint objects.
 */
public class ConstraintObjectsTest {

    // Bandwidth Constraint

    final BandwidthConstraint bandwidthConstraint1 =
            new BandwidthConstraint(Bandwidth.bps(100.0));
    final BandwidthConstraint bandwidthConstraintSameAs1 =
            new BandwidthConstraint(Bandwidth.bps(100.0));
    final BandwidthConstraint bandwidthConstraint2 =
            new BandwidthConstraint(Bandwidth.bps(200.0));

    /**
     * Checks that the objects were created properly.
     */
    @Test
    public void testBandwidthConstraintCreation() {
        assertThat(bandwidthConstraint1.bandwidth().toDouble(), is(equalTo(100.0)));
        assertThat(bandwidthConstraintSameAs1.bandwidth().toDouble(), is(equalTo(100.0)));
        assertThat(bandwidthConstraint2.bandwidth().toDouble(), is(equalTo(200.0)));
    }

    /**
     * Checks the correctness of the equals() method.
     */
    @Test
    public void testBandwidthConstraintEquals() {
        new EqualsTester()
                .addEqualityGroup(bandwidthConstraint1, bandwidthConstraintSameAs1)
                .addEqualityGroup(bandwidthConstraint2)
                .testEquals();
    }

    // Lambda Constraint

    final LambdaConstraint lambdaConstraint1 =
            new LambdaConstraint(Lambda.valueOf(100));
    final LambdaConstraint lambdaConstraintSameAs1 =
            new LambdaConstraint(Lambda.valueOf(100));
    final LambdaConstraint lambdaConstraint2 =
            new LambdaConstraint(Lambda.valueOf(200));

    /**
     * Checks that the objects were created properly.
     */
    @Test
    public void testLambdaConstraintCreation() {
        assertThat(lambdaConstraint1.lambda().toInt(), is(equalTo(100)));
        assertThat(lambdaConstraintSameAs1.lambda().toInt(), is(equalTo(100)));
        assertThat(lambdaConstraint2.lambda().toInt(), is(equalTo(200)));
    }

    /**
     * Checks the correctness of the equals() method.
     */
    @Test
    public void testLambdaConstraintEquals() {
        new EqualsTester()
            .addEqualityGroup(lambdaConstraint1, lambdaConstraintSameAs1)
            .addEqualityGroup(lambdaConstraint2)
            .testEquals();
    }

    // LinkType Constraint

    final LinkTypeConstraint linkTypeConstraint1 =
            new LinkTypeConstraint(true, Link.Type.OPTICAL, Link.Type.TUNNEL);
    final LinkTypeConstraint linkTypeConstraintSameAs1 =
            new LinkTypeConstraint(true, Link.Type.OPTICAL, Link.Type.TUNNEL);
    final LinkTypeConstraint linkTypeConstraint2 =
            new LinkTypeConstraint(true, Link.Type.OPTICAL, Link.Type.DIRECT);

    /**
     * Checks that the objects were created properly.
     */
    @Test
    public void testLinkTypeConstraintCreation() {
        assertThat(linkTypeConstraint1.isInclusive(), is(true));
        assertThat(linkTypeConstraint1.types(),
                   contains(Link.Type.OPTICAL, Link.Type.TUNNEL));
        assertThat(linkTypeConstraintSameAs1.isInclusive(), is(true));
        assertThat(linkTypeConstraintSameAs1.types(),
                contains(Link.Type.OPTICAL, Link.Type.TUNNEL));
        assertThat(linkTypeConstraint2.isInclusive(), is(true));
        assertThat(linkTypeConstraint2.types(),
                contains(Link.Type.OPTICAL, Link.Type.DIRECT));
    }

    /**
     * Checks the correctness of the equals() method.
     */
    @Test
    public void testLinkTypeConstraintEquals() {
        new EqualsTester()
                .addEqualityGroup(linkTypeConstraint1, linkTypeConstraintSameAs1)
                .addEqualityGroup(linkTypeConstraint2)
                .testEquals();
    }
}
