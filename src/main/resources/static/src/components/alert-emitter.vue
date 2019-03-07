<template>
    <div class="z-level4">
        <div class="cmp-alert-emitter_pool" aria-hidden="true" v-show="pool.length > 0">
            <alert
                v-for="alert in pool"
                :key="alert.id"
                :type="alert.type"
                :animate="(alert.type != 'warning' && alert.type != 'error')"
                @closed="deleteElement(alert.id)"
                class="slds-notify_toast slds-m-bottom_xx-small"
            >
                <span v-html="alert.message"></span>
            </alert>
        </div>
    </div>
</template>

<script>
    import Alert from './alert.vue';
    import EM from '../core/event-emitter.js';

    // Events Constants
    const PUSH = 'AlertEmitter.push';
    const CLEAR = 'AlertEmitter.clear';

    export default {
        //
        // LOCAL COMPONENTS
        //
        components: {
            Alert
        },

        //
        // CONSTANTS
        //
        PUSH: PUSH,
        CLEAR: CLEAR,

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pool: []
            }
        },

        //
        // METHODS
        //
        methods: {
            deleteElement: function(id) {
                let index = this.pool.findIndex((alert) => {
                    return alert.id == id;
                });
                this.pool.splice(index, 1);
            }
        },

        //
        // EVENTS
        //
        created() {
            EM.$on(PUSH, (params) => {
                if (params && params.message) {
                    params.id = Math.floor( Math.random() *1000 *1000 );
                    this.pool.push(params);
                }
            });
            EM.$on(CLEAR, () => {
                this.pool = [];
            });
        }
    }
</script>

<style scoped>
    .cmp-alert-emitter_pool {
        position: fixed;
        top: 1rem;
        left: 50%;
        width: 400px;
        margin-left: -200px;
        z-index: 6000;
    }
</style>
