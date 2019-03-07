<template>
    <div
        class="slds-notify slds-notify_alert slds-theme_alert-texture"
        :class="[
                computedPreset.class,
                this.fixed && 'cmp-alert_fixed slds-notify_toast',
                this.startAnimation && 'cmp-alert_animate',
                this.closed && 'cmp-alert_closed'
            ].join(' ')
        "
        role="alert"
    >
        <span v-show="showIcon" class="slds-icon_container slds-m-right_x-small">
            <icon :icon="computedPreset.icon" class="slds-icon slds-icon_x-small" />
        </span>
        <slot></slot>

        <div class="slds-notify__close">
            <button @click="close" class="slds-button slds-button_icon slds-button_icon-small slds-button_icon-inverse" title="Close">
                <icon icon="times" class="slds-button__icon" />
            </button>
        </div>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faCheckCircle, faExclamationTriangle, faExclamationCircle, faBan, faTimes} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faCheckCircle, faExclamationTriangle, faExclamationCircle, faBan, faTimes);

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            type: {
                type: String
            },
            showIcon: {
                type: Boolean,
                default: true
            },
            fixed: {
                type: Boolean,
                default: false
            },
            animate: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                presets: new Map([
                    ['info', {
                        'class': 'slds-theme_info',
                        'icon': 'exclamation-circle'
                    }],
                    ['warning', {
                        'class': 'slds-theme_warning',
                        'icon': 'exclamation-triangle'
                    }],
                    ['error', {
                        'class': 'slds-theme_error',
                        'icon': 'ban'
                    }],
                    ['success', {
                        'class': 'slds-theme_success',
                        'icon': 'check-circle'
                    }]
                ]),
                defaultType: 'info',

                startAnimation: false,
                closed: false
            }
        },
        computed: {
            computedPreset: function() {
                let actualType = this.presets.has(this.type) ? this.type : this.defaultType;

                return this.presets.get(actualType);
            }
        },

        //
        // METHODS
        //
        methods: {
            close() {
                this.closed = true;
                this.$emit('closed');
            }
        },

        //
        // EVENTS
        //
        mounted() {
            if (this.animate) {
                setTimeout(() => {
                    this.startAnimation = true;
                }, 3000);
                setTimeout(() => {
                    this.close();
                }, 4000);
            }
        }
    }
</script>

<style scoped>
    .cmp-alert_fixed {
        position: fixed;
        right: 1rem;
        bottom: 1rem;
        z-index: 6000;
        max-width: 250px;
    }
    .cmp-alert_animate {
        opacity: 0;
        transition: opacity 1s;
    }
    .cmp-alert_closed {
        display: none;
    }
</style>
