package daishin.cputil  ;

import com4j.*;

/**
 * ICpCybos Interface
 */
@IID("{3722B490-A340-45C5-BDA5-3C736DDEB423}")
public interface ICpCybos extends Com4jObject {
  // Methods:
  /**
   * <p>
   * property IsConnect
   * </p>
   * <p>
   * Getter method for the COM property "IsConnect"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  int isConnect();


  /**
   * <p>
   * property ServerType
   * </p>
   * <p>
   * Getter method for the COM property "ServerType"
   * </p>
   * @return  Returns a value of type short
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  short serverType();


  /**
   * <p>
   * property LimitRequestRemainTime
   * </p>
   * <p>
   * Getter method for the COM property "LimitRequestRemainTime"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  int limitRequestRemainTime();


  /**
   * <p>
   * method GetLimitRemainCount
   * </p>
   * @param limitType Mandatory daishin.cputil.LIMIT_TYPE parameter.
   * @return  Returns a value of type int
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  int getLimitRemainCount(
    daishin.cputil.LIMIT_TYPE limitType);


  /**
   * <p>
   * method CreonPlusConnect
   * </p>
   * @param bstID Mandatory java.lang.String parameter.
   * @param bstPWD Mandatory java.lang.String parameter.
   * @param bstPKI Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  java.lang.String creonPlusConnect(
    java.lang.String bstID,
    java.lang.String bstPWD,
    java.lang.String bstPKI);


  /**
   * <p>
   * method CybosPlusConnect
   * </p>
   * @param bstID Mandatory java.lang.String parameter.
   * @param bstPWD Mandatory java.lang.String parameter.
   * @param bstPKI Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(12)
  java.lang.String cybosPlusConnect(
    java.lang.String bstID,
    java.lang.String bstPWD,
    java.lang.String bstPKI);


  /**
   * <p>
   * method PlusDisconnect
   * </p>
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(13)
  void plusDisconnect();


  /**
   * <p>
   * method GetLimitRemainTime
   * </p>
   * @param limitType Mandatory daishin.cputil.LIMIT_TYPE parameter.
   * @return  Returns a value of type int
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(14)
  int getLimitRemainTime(
    daishin.cputil.LIMIT_TYPE limitType);


  // Properties:
}
