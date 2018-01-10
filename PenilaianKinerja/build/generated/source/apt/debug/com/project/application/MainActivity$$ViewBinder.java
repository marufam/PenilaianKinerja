// Generated code from Butter Knife. Do not modify!
package com.project.application;

import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.github.florent37.materialviewpager.MaterialViewPager;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$ViewBinder<T extends MainActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends MainActivity> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.mViewPager = finder.findRequiredViewAsType(source, 2131230825, "field 'mViewPager'", MaterialViewPager.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.mViewPager = null;

      this.target = null;
    }
  }
}
