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

/** 
 * 1.0 way of drawing : 
 * - isolation of actual engine
 * - no dependency off API on third party
 * - reverse dependency of delaunay
 * 
 * - enrichir IAxe avec toutes les méthodes de axebox
 * 
 * implementation embed
 * - GL
 * - GLU
 * - View
 * - Camera
*/
public interface Painter {
    enum Geometry{
        POINT, LINE, POLYGON
    }
    
    public void begin(Geometry geometry);
    public void end();
    public void vertex(Coord3d coord);
    public void vertex(Coord3d coord, SpaceTransformer transform);

    public void color(Color color);
    public void colorAlphaOverride(Color color, float alpha);
    public void colorAlphaFactor(Color color, float alpha);
    
    public void transform(Transform transform, boolean loadIdentity);
    
    
    
    // technical
    public void culling(boolean status);
    public void lights(boolean status);
    public void polygonOffset(boolean status);
    
    
    // ease
    public Camera getCamera();
    public void setCamera(Camera camera);

    public View getView();
    public IScreenCanvas getCanvas();
    public Scene getScene();
    public IAxe getAxe();
    
    
    // GL INTERFACE
    
    public void glLoadIdentity();
    public void glScalef(float x, float y, float z);
    
    public void glBegin(int type);
	public void glEnd();

	public void glColor3f(float r, float g, float b);
    public void glColor4f(float r, float g, float b, float a);
    public void glVertex3f(float x, float y, float z);
    public void glVertex3d(double x, double y, double z);
	
    public void glEnable(int type);
    public void glDisable(int type);

    public void glPolygonMode(int frontOrBack, int fill);
    public void glPolygonOffset(float factor, float units);
    
    public void glLineStipple(int factor, short pattern);
    
    public void glLineWidth(float width);
	public void glPointSize(float width);
	
    public void glTexCoord2f(float s, float t);
    public void glTexEnvf(int target, int pname, float param);
    public void glTexEnvi(int target, int pname, int param);
    
    public void glPushMatrix();
    public void glPopMatrix();

}
