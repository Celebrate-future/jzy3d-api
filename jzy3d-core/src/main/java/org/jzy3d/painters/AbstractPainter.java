package org.jzy3d.painters;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.axes.IAxe;
import org.jzy3d.plot3d.rendering.canvas.IScreenCanvas;
import org.jzy3d.plot3d.rendering.scene.Scene;
import org.jzy3d.plot3d.rendering.view.Camera;
import org.jzy3d.plot3d.rendering.view.View;
import org.jzy3d.plot3d.transform.Transform;
import org.jzy3d.plot3d.transform.space.SpaceTransformer;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;

public abstract class AbstractPainter implements Painter{

	protected Camera camera;
	protected View view;
	

	public AbstractPainter() {
		super();
	}

	@Override
	public View getView() {
	    return view;
	}

	@Override
	public Camera getCamera() {
	    return camera;
	}

	@Override
	public void setCamera(Camera camera) {
	    this.camera = camera;
	}

	@Override
	public IScreenCanvas getCanvas() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public Scene getScene() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public IAxe getAxe() {
	    // TODO Auto-generated method stub
	    return null;
	}
	
	@Override
	public void transform(Transform transform, boolean loadIdentity) {
		transform.execute(this, loadIdentity);
	}

	@Override
    public void color(Color color) {
        glColor4f(color.r, color.g, color.b, color.a);
    }
	
	@Override
	public void colorAlphaOverride(Color color, float alpha) {
        glColor4f(color.r, color.g, color.b, alpha);
		
	}

	@Override
	public void colorAlphaFactor(Color color, float alpha) {
        glColor4f(color.r, color.g, color.b, color.a * alpha);
	}
	
	@Override
	public void clearColor(Color color) {
		glClearColor(color.r, color.g, color.b, color.a);
	}

	
	@Override
	public void vertex(Coord3d coord, SpaceTransformer transform) {
		if (transform == null) {
			vertex(coord);
		} else {
			glVertex3f(transform.getX().compute(coord.x), transform.getY().compute(coord.y), transform.getZ().compute(coord.z));
		}
	}
	
	@Override
	public void vertex(float x, float y, float z, SpaceTransformer transform) {
		if (transform == null) {
			glVertex3f(x, y, z);
		} else {
			glVertex3f(transform.getX().compute(x), transform.getY().compute(y), transform.getZ().compute(z));
		}
	}


	@Override
	public void vertex(Coord3d coord) {
		glVertex3f(coord.x, coord.y, coord.z);
	}
	
	@Override
	public void normal(Coord3d norm) {
		glNormal3f(norm.x, norm.y, norm.z);
	}

	@Override
	public void raster(Coord3d coord, SpaceTransformer transform) {
		if (transform == null) {
			glRasterPos3f(coord.x, coord.y, coord.z);
		} else {
			glRasterPos3f(transform.getX().compute(coord.x), transform.getY().compute(coord.y), transform.getZ().compute(coord.z));
		}
	}
	
	@Override
	public void material(int face, int pname, Color color) {
		glMaterialfv(face, pname, color.toArray(), 0);
	}
	
	@Override
	public int[] getViewPortAsInt() {
        int viewport[] = new int[4];
        glGetIntegerv(GL.GL_VIEWPORT, viewport, 0);
        return viewport;
    }

	@Override
	public double[] getProjectionAsDouble() {
        double projection[] = new double[16];
        glGetDoublev(GLMatrixFunc.GL_PROJECTION_MATRIX, projection, 0);
        return projection;
    }

	@Override
	public float[] getProjectionAsFloat() {
        float projection[] = new float[16];
        glGetFloatv(GLMatrixFunc.GL_PROJECTION_MATRIX, projection, 0);
        return projection;
    }

	@Override
	public double[] getModelViewAsDouble() {
        double modelview[] = new double[16];
        glGetDoublev(GLMatrixFunc.GL_MODELVIEW_MATRIX, modelview, 0);
        return modelview;
    }

	@Override
	public float[] getModelViewAsFloat() {
        float modelview[] = new float[16];
        glGetFloatv(GLMatrixFunc.GL_MODELVIEW_MATRIX, modelview, 0);
        return modelview;
    }

}