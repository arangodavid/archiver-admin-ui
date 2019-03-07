<template>
    <div class="z-level9" v-show="queue > 0">
        <div class="slds-backdrop slds-backdrop_open cmp-page-loader_overlay"></div>

        <loader class="cmp-page-loader_spinner" />
    </div>
</template>

<script>
    import Loader from './loader.vue';
    import EM from '../core/event-emitter.js';

    // Events Constants
    const SHOW = 'PageLoader.show';
    const HIDE = 'PageLoader.hide';
    const HIDE_ALL = 'PageLoader.hideAll';

    export default {
        //
        // LOCAL COMPONENTS
        //
        components: {
            Loader
        },

        //
        // CONSTANTS
        //
        SHOW: SHOW,
        HIDE: HIDE,
        HIDE_ALL: HIDE_ALL,

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                queue: 0
            }
        },

        //
        // EVENTS
        //
        created() {
            EM.$on(SHOW, () => {
                this.queue++;
            });
            EM.$on(HIDE, () => {
                if (this.queue > 0) this.queue--;
            });
            EM.$on(HIDE_ALL, () => {
                this.queue = 0;
            });
        }
    }
</script>

<style scoped>
    .cmp-page-loader_overlay {
        z-index: 10000 !important;
    }

    .cmp-page-loader_spinner {
        position: fixed;
        top: 50%;
        left: 50%;
        z-index: 10001 !important;

        /* .slds-icon size */
        height: 4rem;
        width: 4rem;
        margin: -2rem 0 0 -2rem;
        /*fill: #fff;*/
    }
</style>
