
// provider0 RelMdPercentageOriginalRows

public final class GeneratedMetadataHandler_NonCumulativeCost implements org.apache.calcite.rel.metadata.BuiltInMetadata.NonCumulativeCost.Handler {
  private final java.util.List relClasses;
  public final org.apache.calcite.rel.metadata.RelMdPercentageOriginalRows provider0;
  public GeneratedMetadataHandler_NonCumulativeCost(java.util.List relClasses,
      org.apache.calcite.rel.metadata.RelMdPercentageOriginalRows provider0) {
    this.relClasses = relClasses;
    this.provider0 = provider0;
  }
  public org.apache.calcite.rel.metadata.MetadataDef getDef() {
    return org.apache.calcite.rel.metadata.BuiltInMetadata$NonCumulativeCost.DEF;
  }
  public org.apache.calcite.plan.RelOptCost getNonCumulativeCost(
      org.apache.calcite.rel.RelNode r,
      org.apache.calcite.rel.metadata.RelMetadataQuery mq) {
    final java.util.List key = org.apache.calcite.runtime.FlatLists.of(org.apache.calcite.rel.metadata.BuiltInMetadata$NonCumulativeCost.DEF);
    final Object v = mq.map.get(r, key);
    if (v != null) {
      if (v == org.apache.calcite.rel.metadata.NullSentinel.ACTIVE) {
        throw new org.apache.calcite.rel.metadata.CyclicMetadataException();
      }
      if (v == org.apache.calcite.rel.metadata.NullSentinel.INSTANCE) {
        return null;
      }
      return (org.apache.calcite.plan.RelOptCost) v;
    }
    mq.map.put(r, key,org.apache.calcite.rel.metadata.NullSentinel.ACTIVE);
    try {
      final org.apache.calcite.plan.RelOptCost x = getNonCumulativeCost_(r, mq);
      mq.map.put(r, key, org.apache.calcite.rel.metadata.NullSentinel.mask(x));
      return x;
    } catch (java.lang.Exception e) {
      mq.map.row(r).clear();
      throw e;
    }
  }

  private org.apache.calcite.plan.RelOptCost getNonCumulativeCost_(
      org.apache.calcite.rel.RelNode r,
      org.apache.calcite.rel.metadata.RelMetadataQuery mq) {
    switch (relClasses.indexOf(r.getClass())) {
    default:
      return provider0.getNonCumulativeCost((org.apache.calcite.rel.RelNode) r, mq);
    case 3:
      return getNonCumulativeCost(((org.apache.calcite.plan.hep.HepRelVertex) r).getCurrentRel(), mq);
    case -1:
      throw new org.apache.calcite.rel.metadata.JaninoRelMetadataProvider$NoHandler(r.getClass());
    }
  }

}
