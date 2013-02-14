import static com.googlecode.javacv.cpp.opencv_core.cvGet2D;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_EVENT_MOUSEMOVE;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_WINDOW_AUTOSIZE;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvNamedWindow;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSetMouseCallback;
import static com.googlecode.javacv.cpp.opencv_highgui.cvShowImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvWaitKey;

import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvMouseCallback;

public class getRGB{
	
	public static int x_co;
	public static int y_co; 
	
	public static void main (String[] args){
		
		final IplImage src = cvLoadImage("resources/test.png");
		cvNamedWindow("Image",CV_WINDOW_AUTOSIZE);			    
	    
	    CvMouseCallback on_mouse = new CvMouseCallback() {
            @Override
            public void call(int event, int x, int y, int flags, 
            		com.googlecode.javacpp.Pointer param) {
            	if (event == CV_EVENT_MOUSEMOVE){
            		x_co = x;
            		y_co = y;
            	}
            	CvScalar s=cvGet2D(src,y_co,x_co);                
                System.out.println( "B:"+ s.val(0) + " G:" + s.val(1) + " R:" + s.val(2));
            }
        };
        
        cvSetMouseCallback("Image", on_mouse, null);        
	    cvShowImage("Image", src);
	    cvWaitKey(0);
	}	
}
