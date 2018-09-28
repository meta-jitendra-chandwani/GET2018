/**
 * TriangleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package areas;

public interface TriangleService extends javax.xml.rpc.Service {
    public java.lang.String getTriangleAddress();

    public areas.Triangle getTriangle() throws javax.xml.rpc.ServiceException;

    public areas.Triangle getTriangle(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
