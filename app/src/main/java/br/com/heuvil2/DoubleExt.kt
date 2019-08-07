package br.com.heuvil2

fun Double.toFixed(digits: Int) = String.format("%.${digits}f", this)