<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: ShchykalauM
  Date: 22.02.2017
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<div id="tournaments">
    <div class="title">
        <span><span class="block-title-icon"></span>Турниры</span>
    </div>
    <ul class="menu">
        <li>
            <div class="menu-item"><a href="${pageContext.request.contextPath}/0">
                <div class="login-content">
                    <span class="icon russia"></span>
                    <span class="title">Россия</span>

                </div></a>
            </div>
        </li>
        <li>
            <div class="menu-item">
                <div class="menu-item"><a href="${pageContext.request.contextPath}/1">
                    <div class="login-content">
                        <span class="icon lc"></span>
                        <span class="title">Лига Чемпионав</span>

                    </div> </a>
                </div>
            </div>
        </li>
        <li>
            <div class="menu-item">
                <div class="menu-item"><a href="${pageContext.request.contextPath}/2">
                    <div class="login-content">
                        <span class="icon le"></span>
                        <span class="title">Лига Европы</span>


                    </div> </a>
                </div>
            </div>
        </li>
        <li>
            <div class="menu-item"><a href="${pageContext.request.contextPath}/3">
                <div class="login-content">
                    <span class="icon england"></span>
                    <span class="title">Англия</span>


                </div>  </a>
            </div>
        </li>
        <li>
            <div class="menu-item"><a href="${pageContext.request.contextPath}/4">
                <div class="login-content">
                    <span class="icon spain"></span>
                    <span class="title">Испания</span>


                </div>   </a>
            </div>
        </li>
        <li>
            <div class="menu-item"><a href="${pageContext.request.contextPath}/5">
                <div class="login-content">
                    <span class="icon italy"></span>
                    <span class="title">Италия</span>


                </div></a>
            </div>
        </li>
        <li>
            <div class="menu-item"><a href="${pageContext.request.contextPath}/6">
                <div class="login-content">
                    <span class="icon germany"></span>
                    <span class="title">Германия</span>


                </div> </a>
            </div>
        </li>
        <li>
            <div class="menu-item"><a href="${pageContext.request.contextPath}/8">
                <div class="login-content">
                    <span class="icon france"></span>
                    <span class="title">Франция</span>


                </div></a>
            </div>
        </li>
    </ul>
</div>