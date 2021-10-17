package com.example.test.dependencies.configuration

import javax.inject.Inject

/**
*
* класс для конфигураций проекта, сюда можно включать номер версии, url и тд
*
* */
class ConfigurationImpl @Inject constructor() : Configuration {

    override val baseUrl: String = "https://api.stackexchange.com"
}