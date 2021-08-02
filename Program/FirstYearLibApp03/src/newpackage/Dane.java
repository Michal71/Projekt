package newpackage;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7C41D620-695F-EE90-2B77-49D192500425]
// </editor-fold> 

/**
 * @author neonet
 */
public class Dane {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9CCE7313-5D7B-A8DE-9B1F-15D6ED693FBC]
    // </editor-fold> 
    static double angle;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E16627CA-B751-71B1-2D52-D19781498DDB]
    // </editor-fold> 
    static double distance;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.81BF8F6B-9BED-3836-877E-330BEF96E11B]
    // </editor-fold> 
    static double height;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.26FCC130-7C14-B8EE-15B3-FCC3E62A3A96]
    // </editor-fold> 
    static double speed;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7446F966-541D-A36D-60E8-5DD12F9A55ED]
    // </editor-fold> 
    static double time;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.49F6B1DA-8052-5B74-405E-1DADF3CC4054]
    // </editor-fold> 
    // oblicza czas lotu nie uwzględniając oporu powietrza
    static double calculateTime() {
        double res1 = (speed * Math.sin(angle / 180 * Math.PI) / 9.81)
                + Math.sqrt((2 * height / 9.81) +
                ((speed * Math.sin(angle / 180 * Math.PI) / 9.81) *
                        (speed * Math.sin(angle / 180 * Math.PI) / 9.81)));
        return res1;
    }

    // oblicza zasięg nie uwzględniając oporu powietrza
    static double calculateDistance() {
        double res2 = ((speed * Math.sin(angle / 180 * Math.PI) / 9.81) + Math.sqrt((2 * height / 9.81) + ((speed * Math.sin(angle / 180 * Math.PI) / 9.81) * (speed * Math.sin(angle / 180 * Math.PI) / 9.81)))) * speed * Math.cos(angle / 180 * Math.PI);
        return res2;
    }

}

