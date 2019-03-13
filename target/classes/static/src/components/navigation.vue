<template>
    <div class="z-level5">
        <div class="slds-backdrop" :class="{'slds-backdrop_open': isOpen}" @click="close"></div>

        <div class="header" :class="{'header-expanded': isOpen}" @click="open">
            <div class="logo logo-sign">
                <img alt="Cervello" src="/assets/img/logo-sign.png" />
            </div>
            <div class="logo logo-full">
                <img alt="Cervello" src="/assets/img/logo-full.png" />
            </div>

            <div class="nav-sign">
                <icon icon="bars" class="slds-icon" />
            </div>
            <div class="nav" @click.stop>
                <router-link :to="{name: 'home'}" exact active-class="active" @click="close">Home</router-link>
                <router-link :to="{name: 'bulkJobs'}" active-class="active" @click="close">Bulk Jobs Manager</router-link>
                <router-link :to="{name: 'relationshipManager'}" active-class="active" @click="close">Relationship Manager</router-link>
                <router-link :to="{name: 'jobLogs'}" active-class="active" @click="close">Job Logs</router-link>
                <router-link :to="{name: 'appConfiguraion'}" active-class="active" @click="close">App Configuraion</router-link>
                <router-link :to="{name: 'objectConfiguration'}" active-class="active" @click="close">Object Configuration</router-link>
            </div>


            <div class="userinfo">
                <div class="userinfo-icon">
                    <icon icon="user-alt" class="slds-icon slds-icon_xx-small" />
                </div>
                <div class="userinfo-menu">
                    <div>
                        <div class="userinfo-username">user-name</div>
                        <a href="/">Settings</a>
                        <a href="/logout">Logout</a>
                    </div>
                    <div>
                        <a href="/login">Sign In</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faBars, faUserAlt} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faBars, faUserAlt);

    export default {
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                isOpen: false
            }
        },

        //
        // METHODS
        //
        methods: {
            open() {
                if (!this.isOpen) this.isOpen = true;
            },
            close() {
                this.isOpen = false;
            }
        },

        //
        // EVENTS
        //
        mounted() {
            this.$router.afterEach((to, from) => {
                this.close();
            })
        }
    }
</script>

<style scoped>

</style>
