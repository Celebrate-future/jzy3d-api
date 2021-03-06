package org.jzy3d.chart;

import org.jzy3d.plot3d.rendering.canvas.EmulGLCanvas;

public class EmulGLAnimator implements IAnimator {
  private static final int RENDERING_LOOP_PAUSE = 100;
  protected EmulGLCanvas canvas;
  protected Thread t;
  protected boolean loop = false;


  public EmulGLAnimator(EmulGLCanvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public void start() {
    stop();

    t = new Thread(new Runnable() {

      @Override
      public void run() {
        loop = true;

        while (loop) {
          canvas.doDisplay();

          try {
            Thread.sleep(RENDERING_LOOP_PAUSE);
          } catch (InterruptedException e) {
          }
        }
      }

    }, "org.jzy3d.chart.EmulGLAnimator");
    t.start();
  }

  @Override
  public void stop() {
    if (t != null) {
      loop = false;
    }
  }
}
