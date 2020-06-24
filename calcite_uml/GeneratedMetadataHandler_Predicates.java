//provider0 RelMdPredicates

public final class GeneratedMetadataHandler_Predicates implements org.apache.calcite.rel.metadata.BuiltInMetadata.Predicates.Handler {
  private final java.util.List relClasses;
  public final org.apache.calcite.rel.metadata.RelMdPredicates provider0;
  public GeneratedMetadataHandler_Predicates(java.util.List relClasses,
      org.apache.calcite.rel.metadata.RelMdPredicates provider0) {
    this.relClasses = relClasses;
    this.provider0 = provider0;
  }
  public org.apache.calcite.rel.metadata.MetadataDef getDef() {
    return org.apache.calcite.rel.metadata.BuiltInMetadata$Predicates.DEF;
  }
  public org.apache.calcite.plan.RelOptPredicateList getPredicates(
      org.apache.calcite.rel.RelNode r,
      org.apache.calcite.rel.metadata.RelMetadataQuery mq) {
    final java.util.List key = org.apache.calcite.runtime.FlatLists.of(org.apache.calcite.rel.metadata.BuiltInMetadata$Predicates.DEF);
    final Object v = mq.map.get(r, key);
    if (v != null) {
      if (v == org.apache.calcite.rel.metadata.NullSentinel.ACTIVE) {
        throw new org.apache.calcite.rel.metadata.CyclicMetadataException();
      }
      if (v == org.apache.calcite.rel.metadata.NullSentinel.INSTANCE) {
        return null;
      }
      return (org.apache.calcite.plan.RelOptPredicateList) v;
    }
    mq.map.put(r, key,org.apache.calcite.rel.metadata.NullSentinel.ACTIVE);
    try {
      final org.apache.calcite.plan.RelOptPredicateList x = getPredicates_(r, mq);
      mq.map.put(r, key, org.apache.calcite.rel.metadata.NullSentinel.mask(x));
      return x;
    } catch (java.lang.Exception e) {
      mq.map.row(r).clear();
      throw e;
    }
  }

  private org.apache.calcite.plan.RelOptPredicateList getPredicates_(
      org.apache.calcite.rel.RelNode r,
      org.apache.calcite.rel.metadata.RelMetadataQuery mq) {
    switch (relClasses.indexOf(r.getClass())) {
    default:
      return provider0.getPredicates((org.apache.calcite.rel.RelNode) r, mq);
    case 2:
      return provider0.getPredicates((org.apache.calcite.plan.volcano.RelSubset) r, mq);
    case 3:
      return getPredicates(((org.apache.calcite.plan.hep.HepRelVertex) r).getCurrentRel(), mq);
    case 6:
    case 24:
    case 30:
      return provider0.getPredicates((org.apache.calcite.rel.core.Aggregate) r, mq);
    case 9:
    case 33:
      return provider0.getPredicates((org.apache.calcite.rel.core.Exchange) r, mq);
    case 10:
    case 25:
    case 34:
      return provider0.getPredicates((org.apache.calcite.rel.core.Filter) r, mq);
    case 11:
    case 35:
      return provider0.getPredicates((org.apache.calcite.rel.core.Intersect) r, mq);
    case 12:
    case 27:
    case 36:
      return provider0.getPredicates((org.apache.calcite.rel.core.Join) r, mq);
    case 13:
    case 37:
      return provider0.getPredicates((org.apache.calcite.rel.core.Minus) r, mq);
    case 14:
    case 26:
    case 38:
      return provider0.getPredicates((org.apache.calcite.rel.core.Project) r, mq);
    case 15:
    case 39:
      return provider0.getPredicates((org.apache.calcite.rel.core.Sort) r, mq);
    case 17:
    case 41:
      return provider0.getPredicates((org.apache.calcite.rel.core.TableModify) r, mq);
    case 18:
    case 28:
    case 42:
    case 50:
      return provider0.getPredicates((org.apache.calcite.rel.core.TableScan) r, mq);
    case 19:
    case 43:
      return provider0.getPredicates((org.apache.calcite.rel.core.Union) r, mq);
    case -1:
      throw new org.apache.calcite.rel.metadata.JaninoRelMetadataProvider$NoHandler(r.getClass());
    }
  }

}
